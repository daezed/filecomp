import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by nathan on 2/4/2016.
 */
public class filecomp {
    public static void main(String[] args){
        File input=new File(""),input2;

        input2=new File(new File(filecomp.class.getProtectionDomain().getCodeSource().getLocation().getFile()).getParent()+"\\answer.txt");
        File directory = new File(new File(filecomp.class.getProtectionDomain().getCodeSource().getLocation().getFile()).getParent());

        System.out.println(new File(new File(filecomp.class.getProtectionDomain().getCodeSource().getLocation().getFile()).getParent()));

        String [] directoryContents = directory.list();

        List<String> fileLocations = new ArrayList<String>();

        for(String fileName: directoryContents) {
            File temp = new File(String.valueOf(directory),fileName);
            fileLocations.add(String.valueOf(temp));
            if(String.valueOf(temp).contains("_ref")) {
                input=temp;
                System.out.println(String.valueOf(temp));
            }
        }
        try {
            Scanner in = new Scanner(input);
            Scanner in2 = new Scanner(input2);
            File output = new File("output.txt");
            FileWriter fw = new FileWriter(output);
            BufferedWriter bw = new BufferedWriter(fw);
            String end="";
            int i =1;
            while(in.hasNext()&&in2.hasNext()){
                String out;
                out=in.nextLine();
                out.trim();
                String out2;
                out2=in2.nextLine();
                out2.trim();
                if(out.equals(out2)){
                    System.out.println(i+"true");
                }else{
                    System.out.println(i+"false");
                    end=(end+"<"+i+">");

                }
                i++;
                //System.out.println(out);
            }
            bw.write(end);
            bw.newLine();
            bw.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }




    }
}
