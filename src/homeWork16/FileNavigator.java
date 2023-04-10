package homeWork16;

import java.util.*;

public class FileNavigator {

    private Map<String, List<FileData>> fileMap = new HashMap<>();

    public void add(String path, FileData fileData) {
        List<FileData> fileDataList = new ArrayList<>();

        if (isPathMatch(path, fileData)) {
            if (fileMap.containsKey(path)) {
                fileDataList = fileMap.get(path);
                fileDataList.add(fileData);
            } else {
                fileDataList.add(fileData);
                fileMap.put(path, fileDataList);
            }
        } else {
            System.out.println("Path does not match");
        }

    }

    public List<FileData> find(String path) {
        return fileMap.get(path);
    }

    public List<FileData> filterBySize(int maxFileSize) {
        List<FileData> result = new ArrayList<>();

        for (Map.Entry<String, List<FileData>> entry : fileMap.entrySet()) {
            List<FileData> fileDataList = entry.getValue();
            for (FileData fileData : fileDataList) {
                if (fileData.getSize() < maxFileSize) {
                    result.add(fileData);
                }
            }
        }
        return result;
    }

    public void remove(String path) {
        fileMap.remove(path);
    }

    public List<FileData> sortBySize() {
        List<FileData> result = new ArrayList<>();

        for (Map.Entry<String, List<FileData>> entry : fileMap.entrySet()) {
            List<FileData> fileDataList = entry.getValue();
            result.addAll(fileDataList);
        }
        Collections.sort(result);
        return result;
    }

    private boolean isPathMatch(String path, FileData fileData) {
        return path.equals(fileData.getPath());
    }
}
