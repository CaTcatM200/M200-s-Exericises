import java.io.File;
import java.lang.reflect.Array;
    public class FileSearch {
        public FileSearch() {}
        public File[] Search(String filename,String filepath) {
            File file = new File(filepath);
            assert file.list() != null;
            File[] resultlist = new File[0];
            int i = 0;
            if (file.isDirectory()) {
                for (String childname : file.list()) {
                    File child = new File(filepath, childname);
                    if (child.getName().equals(filename)){
                        resultlist = new File[i+1];
                        resultlist[i] = child;
                        i++;
                        System.out.println(resultlist.length);
                    }
                    if (child.isDirectory()) {
                        File[] childlist = Search(filename, child.getPath());
                        System.out.println("r" + resultlist.length);
                        System.out.println("e" + childlist.length);
                        File[] alllist = new File[resultlist.length + childlist.length];
                        System.arraycopy(resultlist,0,alllist,0,resultlist.length);
                        System.arraycopy(childlist,0,alllist,resultlist.length,childlist.length);
                        resultlist = alllist;
                        System.out.println(resultlist.length);
                        i += childlist.length;
                    }
                }
            }
            return resultlist;
        }
    }
}
