package reflection;
import character.Client;

import java.lang.reflect.*;

public class Reflection {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException ,InvocationTargetException {

            Class<Client> clientClass = Client.class;

            System.out.println("Declared Methods:");
            Method[] methods = clientClass.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method.getName());
            }
            System.out.println();

            Constructor<Client> constructor = clientClass.getConstructor(String.class, String.class);
            Client client = constructor.newInstance("John Jakes", "303-913-0554");

            try {
                Method setPhoneNumberMethod = clientClass.getMethod("newPhoneNumber", String.class);
                setPhoneNumberMethod.invoke(client, "303-853-8393");
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

            try {
                Method getPhoneNumberMethod = clientClass.getMethod("getPhoneNumber");
                String phoneNumber = (String) getPhoneNumberMethod.invoke(client);
                System.out.println("Phone Number: " + phoneNumber);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }