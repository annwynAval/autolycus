package com.annwyn.autolycus.oss;

import java.io.InputStream;

public interface OssClient {

    String uploadFile(InputStream inputStream);

}
