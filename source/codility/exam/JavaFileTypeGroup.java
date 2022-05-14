package exam;

// you can also use imports, for example:
import java.util.*;

// 파일 타입 통계

class Solution {
    enum FileType {
        MP3("mp3"), AAC("aac"), FLAC("flac"),
        JPG("jpg"), BMP("bmp"), GIF("gif"),
        MP4("mp4"), AVI("avi"), MKV("mkv"),
        OTHER("other");

        String name;
        FileType(String name) {
            this.name = name;
        }

        public static FileType getType(String name) {
            return Arrays.stream(FileType.values())
            .filter(e -> e.name.equals(name))
            .findAny()
            .orElse(OTHER);
        }
    }

    enum FileTypeGroup {
        MUSIC("music", Arrays.asList(FileType.MP3, FileType.AAC, FileType.FLAC)),
        IMAGES("images", Arrays.asList(FileType.JPG, FileType.BMP, FileType.GIF)),
        MOVIES("movies", Arrays.asList(FileType.MP4, FileType.AVI, FileType.MKV)),
        OTHER("other", Arrays.asList(FileType.OTHER));

        String name;
        List<FileType> fileTypes;
        int total;

        FileTypeGroup(String name, List<FileType> fileTypes) {
            this.name = name;
            this.fileTypes = fileTypes;
        }

        void add(int size) {
            this.total += size;
        }

        int getTotal() {
            return this.total;
        }

        public boolean hasFileType(FileType fileType) {
            return fileTypes.stream().anyMatch(e -> e == fileType);
        }

        public static FileTypeGroup findFileType(FileType fileType) {
            return Arrays.stream(FileTypeGroup.values())
            .filter(e -> e.hasFileType(fileType))
            .findAny()
            .orElse(OTHER);
        }
    }

    public String solution(String S) {
        // write your code in Java SE 8
        String[] rows = S.split("\n");

        for (String row : rows) {
            String fileName = row.split(" ")[0];
            String sizeStr = row.split(" ")[1];
            int size = Integer.parseInt(sizeStr.substring(0, sizeStr.length() -1));

            for (int i = fileName.length() -1; i >= 0; i--) {
                String fileTypeStr = fileName.substring(i + 1);

                if(fileName.charAt(i) == '.') {
                    FileType fileType = FileType.getType(fileTypeStr);
                    FileTypeGroup fileTypeGroup = FileTypeGroup.findFileType(fileType);
                    fileTypeGroup.add(size);
                    break;
                }
            }
        }

        StringBuilder result = new StringBuilder();

        for(FileTypeGroup ftg : FileTypeGroup.values()) {
            String type = ftg.name;
            int size = ftg.getTotal();

            result.append(type).append(" ").append(size).append("b");
            result.append(System.lineSeparator());
        }

        return result.toString();
    }
}
