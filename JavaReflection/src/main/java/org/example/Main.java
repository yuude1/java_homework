package org.example;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {
        Superheros invulnerable = new Superheros("Invulnerable","Mark", 19);

        Class<?> clazz = invulnerable.getClass();
        for(Method method : clazz.getDeclaredMethods()) {
            if(method.isAnnotationPresent(RunTimes.class)){
                RunTimes runTimes = method.getAnnotation(RunTimes.class);
                method.setAccessible(true);

                Object[] params;
                if(method.getName().equals("savePeople")){
                    params = new Object[]{234};
                } else if(method.getName().equals("trainHero")){
                    params = new Object[]{"Gym"};
                } else if(method.getName().equals("restAfterBattle")){
                    params = new Object[]{3};
                } else if (method.getName().equals("revealSecret")){
                    params = new Object[]{"Family"};
                } else{
                    params = new Object[]{};
                }

                for (int i = 0; i < runTimes.times();i++){
                    method.invoke(invulnerable, params);
                }
            }
        }
    }
}