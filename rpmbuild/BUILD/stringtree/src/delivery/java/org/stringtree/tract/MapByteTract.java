package org.stringtree.tract;

import org.stringtree.Tract;

public class MapByteTract extends MapTract implements ByteTract {

    public void setContent(String content) {
        put(Tract.CONTENT, content.getBytes());
    }

    public String getContent() {
        return new String(getContentBytes());
    }
    
    public byte[] getContentBytes() {
        Object ret = getObject(Tract.CONTENT);
        if (ret == null || !(ret instanceof byte[])) {
            ret = new byte[] {};
        }
        return (byte[])ret;
    }

    public void setContentBytes(byte[] bytes) {
        put(Tract.CONTENT, bytes);
    }
}
