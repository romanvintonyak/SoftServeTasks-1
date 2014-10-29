package temp;

/**
 * Created by maks on 17.10.2014.
 */
public class JoinThread extends Thread {
    public JoinThread(String name){
        super(name);
    }
    public void run(){
        String Tname = getName();
        System.out.println("Start "+ Tname);
        long time = 0;
        try {
//            switch (Tname) {
//                case "First":
//                    time=5000;
//                case "Second":
//                    time = 1000;
//            }
            if (Tname.equals("First")) {
                time = 5000;


            } else if (Tname.equals("Second")) {
                time = 1000;
            }
            Thread.sleep(time);
        }catch (InterruptedException excep){
            excep.printStackTrace();
        }
    }
}
