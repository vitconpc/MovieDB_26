package vn.com.framgia.movie_db26.utils.common;


public final class StringUtil {

    public static String genUrlImage(String path) {
        return new StringBuilder()
                .append(Constants.BASE_URL_IMAGE)
                .append(path)
                .toString();
    }
}
