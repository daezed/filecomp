import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nathan on 2/4/2016.
 */
public class filecomp {
    public static void main(String[] args){
        File input,input2;

        input2=new File("");
        ClassLoader classLoader = filecomp.class.getClassLoader();
        File directory = new File(new File(filecomp.class.getProtectionDomain().getCodeSource().getLocation().getFile()).getParent());

        System.out.println(new File(new File(filecomp.class.getProtectionDomain().getCodeSource().getLocation().getFile()).getParent()));

        String [] directoryContents = directory.list();

        List<String> fileLocations = new ArrayList<String>();

        for(String fileName: directoryContents) {
            File temp = new File(String.valueOf(directory),fileName);
            input=temp;
            fileLocations.add(String.valueOf(temp));
            if(String.valueOf(temp).contains("_")) {

                System.out.println(String.valueOf(temp));
            }
        }


    }
}
