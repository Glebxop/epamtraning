import com.google.gson.*;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        ControlEventSecondType controlEventSecondType=new ControlEventSecondType(5,6,true);
        ControlEventThirdType controlEventThirdType=new ControlEventThirdType(true,true,20);



        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

       /* JsonDeserializer<AbstractControlEvent> jsonDeserializer=new JsonDeserializer<AbstractControlEvent>() {
            public AbstractControlEvent deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return null;
            }
        }*/

        /*System.out.println(gson.toJson(controlEventSecondType));
        String string=gson.toJson(controlEventSecondType);
        AbstractControlEvent controlEvent=gson.fromJson(string,AbstractControlEvent.class);
        System.out.println(controlEvent.toString());*/

        ControlEventFirstType controlEventFirstType=new ControlEventFirstType(7,7);

        List<AbstractControlEvent>list=new ArrayList<>();
        list.add(controlEventFirstType);
        list.add(controlEventSecondType);
        list.add(controlEventThirdType);

        for (AbstractControlEvent abstractControlEvent:list){
            abstractControlEvent.print();}

        Collections.sort(list);

        List <AbstractControlEvent>passed=new ArrayList<AbstractControlEvent>();
        List<AbstractControlEvent> notPassed=new ArrayList<AbstractControlEvent>();
        for (AbstractControlEvent abstractControlEvent :list){
            if (abstractControlEvent.isPassed()){
                passed.add(abstractControlEvent);
            }else notPassed.add(abstractControlEvent);
        }
        for (AbstractControlEvent abstractControlEvent:passed){
        abstractControlEvent.print();}


    }
}
