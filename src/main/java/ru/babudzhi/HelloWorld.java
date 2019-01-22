package ru.babudzhi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelloWorld {
    public static void main(String[] args) {
        for(String s : args)
        System.out.println(deleteSlash(addUserPassword(s)));
    }
        public static String addUserPassword(String oldUrl){
            String userName = "takoyWotUser";
            String password=  "takoyWotPassword";
            StringBuilder newUrl = new StringBuilder(oldUrl);
            if(checkStrIsUrl(oldUrl)){
                int indexUser = oldUrl.indexOf("://") + 3;
                int indexPassword = oldUrl.indexOf(":",indexUser);

                newUrl.delete(indexUser,indexPassword);
                newUrl.insert(indexUser,userName);

                indexPassword = newUrl.indexOf(":",indexUser +1) + 1;
                int indexEndPassword = newUrl.indexOf("/",indexPassword);

                newUrl.delete(indexPassword,indexEndPassword);
                newUrl.insert(indexPassword,password);
            }
            return newUrl.toString();
        }

        public static boolean checkStrIsUrl(String str){
            Pattern pattern = Pattern.compile("https?://\\w+:\\w+/.+/?");
            Matcher matcher = pattern.matcher(str);
            return matcher.matches();
        }

        public static  String deleteSlash(String oldUrl){
            char[] arr = oldUrl.toCharArray();
            if (arr[arr.length-1] != '/'){
                arr = new char[arr.length+1];
                for(int j = 0; j < arr.length - 1; j ++){
                    arr[j] = oldUrl.toCharArray()[j];
                }
                arr[arr.length-1] = '/';
                return String.valueOf(arr);
            }
            for(int i = arr.length-1; i >= 0; i--){
                if(arr[i-1] == '/'){
                    arr = new char[arr.length-1];
                    for(int j = 0; j < arr.length - 1; j ++){
                        arr[j] = oldUrl.toCharArray()[j];
                    }
                    --i;
                }
                else
                    return String.valueOf(arr);
            }
            return String.valueOf(arr);
        }
}
