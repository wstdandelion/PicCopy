import javax.swing.*;
import java.io.*;

public class PicCopyForChar {
    FileReader fr;
    FileWriter fw;
    String extName;
    public PicCopyForChar(String picPath)  {
        File file=new File(picPath);
        if(!file.exists()){
            JOptionPane.showMessageDialog(null,"输入图片不存在");
            return;
        }else
            try{
                extName=picPath.substring(picPath.lastIndexOf("."));
                fr=new FileReader(file);
            }catch(FileNotFoundException e){
                e.printStackTrace();
            }

    }

    public void uploadPic (String targetPath){
        File file=new File(targetPath);
        try{
            fw=new FileWriter(file);
            int length=fr.read();
            while((length=fr.read())!=-1) {
                fw.write(length);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void close(){
        {
            try {
                if(fw!=null)
                    fw.close();
                if(fr!=null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}