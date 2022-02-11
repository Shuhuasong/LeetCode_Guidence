package Design.Hard;

import java.util.*;

/**
 * Created by Shuhua Song
 */
public class _588_DesignInMemoryFileSystem {

    class Directory{
        Map<String, Directory> dirs;
        Map<String, String> files;
        public Directory(){
            dirs = new HashMap<>();
            files = new HashMap<>();
        }
    }

    Directory root;
    public _588_DesignInMemoryFileSystem() {
        root = new Directory();
    }

    public List<String> ls(String path) {
        Directory curr = root;
        List<String> results = new ArrayList<>();
        if(!path.equals("/")){
            String[] paths = path.split("/");
            int n = paths.length;
            for(int i=1; i<paths.length-1; i++){
                curr = curr.dirs.get(paths[i]);
            }
            //the path is a file
            if(curr.files.containsKey(paths[n-1])){
                results.add(paths[n-1]);
                return results;
            }else{
                curr = curr.dirs.get(paths[n-1]);
            }
            //the path is a dirctory
        }
        results.addAll(new ArrayList<>(curr.dirs.keySet()));
        results.addAll(new ArrayList<>(curr.files.keySet()));
        Collections.sort(results);
        return results;
    }

    public void mkdir(String path) {
        Directory curr = root;
        String[] paths = path.split("/");
        int n = paths.length;
        for(int i=1; i<paths.length; i++){
            String name = paths[i];
            if(!curr.dirs.containsKey(name)){
                curr.dirs.put(name, new Directory());
            }
            curr = curr.dirs.get(name);
        }

    }

    public void addContentToFile(String filePath, String content) {
        Directory curr = root;
        String[] paths = filePath.split("/");
        int n = paths.length;
        for(int i=1; i<n-1; i++){
            String name = paths[i];
            curr = curr.dirs.get(name);
        }
        curr.files.put(paths[n-1], curr.files.getOrDefault(paths[n-1], "")+content);
    }

    public String readContentFromFile(String filePath) {
        Directory curr = root;
        String[] paths = filePath.split("/");
        int n = paths.length;
        for(int i=1; i<paths.length-1; i++){
            curr = curr.dirs.get(paths[i]);
        }
        return curr.files.get(paths[n-1]);
    }


    /*  Time = (m + n + klogk), m = input String len(split),
                         n = the depth of directory level(ls() function)
                         klonk = sort results;

    class File {
        boolean isFile = false;
        Map<String, File> files = new HashMap<>();
        String content = "";
    }

    File root;
    public FileSystem() {
        root = new File();
    }
    //Time = (m + n + klogk)
    public List<String> ls(String path) {
        File curr = root;
        List<String> results = new ArrayList<>();
        if(!path.equals("/")){
            String[] paths = path.split("/");
            int n = paths.length;
            for(int i=1; i<paths.length; i++){
                curr = curr.files.get(paths[i]);
            }
            //the path is a file
            if(curr.isFile){
                results.add(paths[n-1]);
                return results;
            }
        }
        results.addAll(new ArrayList<>(curr.files.keySet()));
        Collections.sort(results);
        return results;
    }

    //Time = (m + n)
    public void mkdir(String path) {
        File curr = root;
        String[] paths = path.split("/");
        int n = paths.length;
        for(int i=1; i<paths.length; i++){
            String name = paths[i];
            if(!curr.files.containsKey(name)){
                curr.files.put(name, new File());
            }
            curr = curr.files.get(name);
        }

    }

    //Time = (m + n)
    public void addContentToFile(String filePath, String content) {
        File curr = root;
        String[] paths = filePath.split("/");
        int n = paths.length;
        for(int i=1; i<n-1; i++){
            String name = paths[i];
            curr = curr.files.get(name);
        }
        if(!curr.files.containsKey(paths[n-1]))
            curr.files.put(paths[n-1], new File());
        curr = curr.files.get(paths[n-1]);
        curr.isFile = true;
        curr.content = curr.content + content;
    }

    public String readContentFromFile(String filePath) {
        File curr = root;
        String[] paths = filePath.split("/");
        int n = paths.length;
        for(int i=1; i<paths.length-1; i++){
            curr = curr.files.get(paths[i]);
        }
        return curr.files.get(paths[n-1]).content;
    }
     */
}
