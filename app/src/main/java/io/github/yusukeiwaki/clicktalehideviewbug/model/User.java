package io.github.yusukeiwaki.clicktalehideviewbug.model;

public class User {
    public final long id;
    public final String name;
    public final String avatarUrl;

    public User(long id, String name, String avatarUrl) {
        this.id = id;
        this.name = name;
        this.avatarUrl = avatarUrl;
    }

    public static final User ME = new User(1, "John", "http://i1.wp.com/d-navi004.com/wp-content/uploads/2014/11/MetroUI-Folder-OS-OS-Android-icon.png");
    public static final User OTHERS = new User(2, "Hanako", "https://lh3.ggpht.com/XL0CrI8skkxnboGct-duyg-bZ_MxJDTrjczyjdU8OP2PM1dmj7SP4jL1K8JQeMIB3AM=w300");
}
