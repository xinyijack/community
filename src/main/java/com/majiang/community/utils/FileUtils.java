package com.majiang.community.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author jack_xin
 * @ClassName FileUtils
 * @Desc TODO
 * @date 2022年04月03日 14:46
 * @Version TODO
 */
@Slf4j
public class FileUtils {
    private static List<String> suffix = new ArrayList<>();

    static {
        suffix.add(".png");
        suffix.add(".bmp");
        suffix.add(".gif");
        suffix.add(".jpeg");
        suffix.add(".jpg");
    }

    public static boolean hasSuffix(String fileName) {
        for (String s : suffix) {
            if (StringUtils.endsWithIgnoreCase(fileName, s)) {
                return true;
            }
        }
        return false;
    }

    public static String newUUIDFileName(String fileName) {
        if (StringUtils.isBlank(fileName)) {
            return fileName;
        }
        if (hasSuffix(fileName)) {
            String[] filePaths = fileName.split("\\.");
            if (filePaths.length > 1) {
                return UUID.randomUUID().toString().replace("-", "") + "." + filePaths[filePaths.length - 1];
            } else {
                return newUUIDPNGFileName();
            }
        } else {
            return newUUIDPNGFileName();
        }
    }

    public static String newUUIDPNGFileName() {
        return UUID.randomUUID().toString().replace("-", "") + ".png";
    }

    public static String newLocalFileName(String fileName) {
        String path = System.getProperty("user.dir") + File.separator;
        return newLocalFileName(path, fileName);
    }

    public static String newLocalFileName(String path, String fileName) {
        return path + newUUIDFileName(fileName);
    }


    public static void deleteFile(File file) {
        try {
            file.delete();
        } catch (Exception e) {
            log.debug("FILE_UTILS_ERROR", e);
        }
    }
}
