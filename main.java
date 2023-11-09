package ru.mirea.dyachenkova.tasktwo;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;
import ru.mirea.dyachenkova.taskone.Answer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

interface AnswerServ {
    @POST("/")
    Call<PrimeRequest> getAnswer(@Body PrimeRequest primeRequest);
}
public class main {
    public static void main(String[] args) throws IOException {
        Retrofit client = new Retrofit
                .Builder()
                .baseUrl("http://prime.tms-studio.ru:8085")
                .addConverterFactory(JacksonConverterFactory.create(new JsonMapper()))
                .build();
        AnswerServ answerServ= client.create(AnswerServ.class);
        Random rd =new Random();
        int[] mas= new int[34];
        int summ=0;
        for (int i=0; i < mas.length ;i++){
            mas[i]=1;
            summ+=mas[i];
        }
        PrimeRequest primeRequest= new PrimeRequest("Дьяченко Владимир Андреевич",34, Arrays.toString(mas).replace("[", "").replace("]", ""));
        Call<PrimeRequest> call=answerServ.getAnswer(primeRequest);
        Response<PrimeRequest> response=call.execute();
        System.out.println(response.body().answer);
        System.out.println(summ);

        try
        {
            File fl=new File("answer.txt");
            fl.createNewFile();
            System.out.println("файл создан");
            FileWriter writer = new FileWriter("answer.txt", false);
            writer.write(String.valueOf(response.body().answer));
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

}
