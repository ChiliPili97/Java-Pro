package homeWork16;

public class FileNavigatorDemo {
    public static void main(String[] args) {
        FileNavigator fileNavigator = new FileNavigator();
        FileData file1 = new FileData("FileData", 23, "/src/homeWork");
        FileData file2 = new FileData("FileNavigator", 50, "/src/homeWork");
        FileData file3 = new FileData("FileNavigatorDemo", 33, "/JavaPro/src/homeWork");
        FileData file4 = new FileData("FileNavigatorDemo1", 42, "/JavaPro/src/homeWork1");

        fileNavigator.add(file1.getPath(), file1);
        fileNavigator.add(file2.getPath(), file2);
        fileNavigator.add(file3.getPath(), file3);
        //fileNavigator.add("/src/homeWork", file4);
        //System.out.println(fileNavigator.find(file1.getPath()));
        //System.out.println(fileNavigator.find(file3.getPath()));
        //System.out.println(fileNavigator.filterBySize(60));
        //System.out.println(fileNavigator.filterBySize(60));
        System.out.println(fileNavigator.sortBySize());
    }
}
