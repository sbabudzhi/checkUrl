

import org.junit.Test;
import ru.babudzhi.HelloWorld;

public class Test1 {
    @Test
    public void checkUrl(){
        String [] ards = new String[]{"https://user:password/jsjkok-;sd////"};
        new HelloWorld().main( ards);
    }
}
