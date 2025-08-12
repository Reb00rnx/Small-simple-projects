
import java.io.*;
import java.util.Scanner;

public class Main {

    public static String enc(String scifer, int num, String alg) {
        StringBuilder builder = new StringBuilder();
        switch (alg){
            case "unicode":

                for (int i = 0;i<scifer.length();i++){
                    char c = scifer.charAt(i);
                    builder.append((char) ((c+ num) % 128));
                }
                return builder.toString();

            case "shift":
                char []sciferArray = scifer.toCharArray();
                for(int i =0;i<scifer.length();i++){
                    char c = sciferArray[i];
                    if(Character.isLetter(c)){
                        if(Character.isUpperCase(c)&& c>='A'&&c<='Z'){
                            builder.append((char) ('A'+(c -'A'+num)%26));
                        }
                        else if (Character.isLowerCase(c)&& c>='a'&&c<='z'){
                            builder.append((char) ('a'+(c -'a'+num)%26));
                        }


                    }else {
                        builder.append(c);
                    }
                }
                return builder.toString();

            default:
                return null;
        }


    }
    public static String dec(String scifer, int num,String alg) {

        StringBuilder builder = new StringBuilder();
        switch (alg){
            case "unicode":
                for (int i = 0;i<scifer.length();i++){
                    char c = scifer.charAt(i);
                    builder.append((char) ((c-num+128)%128));
                }
                return builder.toString();

            case "shift":
                char []sciferArray = scifer.toCharArray();
                for(int i =0;i<scifer.length();i++){
                    char c = sciferArray[i];
                    if(Character.isLetter(c)){
                        if(Character.isUpperCase(c)&& c>='A'&&c<='Z'){
                            builder.append((char) ('A'+(c -'A'-num+26)%26));
                        }
                        else if (Character.isLowerCase(c)&& c>='a'&&c<='z'){
                            builder.append((char) ('a'+(c -'a'-num+26)%26));
                        }


                    }else {
                        builder.append(c);
                    }
                }
                return builder.toString();
            default:
                return null;

        }



    }




    public static void main(String[] args) {
        String mode = "enc";
        String in = "";
        int key = 0;
        String data = "";
        String out = "";
        String read = "";
        String alg = "shift";
        boolean outFlag = true;
        if (data.equals("")&&in.equals("")){
            read = data;
        }


        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-mode":
                    if (i + 1 < args.length) {
                        mode = args[++i];
                    }
                    break;
                case "-key":
                    if (i + 1 < args.length) {
                        key = Integer.parseInt(args[++i]);
                    }
                    break;
                case "-data":
                    if (i + 1 < args.length) {
                        data = args[++i];
                    }
                    break;
                case "-in":
                    if (i + 1 < args.length) {
                        in = args[++i];
                    }
                    try{
                        Scanner scanner = new Scanner(new File(in));
                        read = scanner.nextLine();
                        scanner.close();
                    }catch (FileNotFoundException e){
                        System.out.println("Error");
                    }
                    break;
                case "-out":
                    if (i + 1 < args.length) {
                        out = args[++i];
                    }
                    break;
                case "-alg":
                    if (i + 1 < args.length) {
                        alg = args[++i];
                    }
                    break;
            }
        }

        switch (mode){
            case "enc":
                read = enc(read,key,alg);
                break;
            case "dec":
                read = dec(read,key,alg);
                break;
        }

        if(out.equals("")){
            outFlag = false;
        }
        if (outFlag) {
            try {
                FileWriter writer = new FileWriter(new File(out));
                writer.write(read);
                writer.close();
            } catch (FileNotFoundException e) {
                System.out.println("write fail");

            } catch (IOException e) {
                System.out.println("Error");
            }
        } else {
            System.out.println(read);
        }


    }
}