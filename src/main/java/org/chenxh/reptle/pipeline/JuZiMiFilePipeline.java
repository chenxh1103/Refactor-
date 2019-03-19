package org.chenxh.reptle.pipeline;

import org.apache.commons.codec.digest.DigestUtils;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.utils.FilePersistentBase;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

public class JuZiMiFilePipeline extends FilePersistentBase implements Pipeline{

    public JuZiMiFilePipeline(String path) {
        this.setPath(path);
    }
    @Override
    public void process(ResultItems resultItems, Task task) {
        String path = this.path + PATH_SEPERATOR + task.getUUID() + PATH_SEPERATOR;
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(this.getFile(path + DigestUtils.md5Hex(resultItems.getRequest().getUrl()) + ".json")));
            Iterator iterable = resultItems.getAll().values().iterator();
            while (iterable.hasNext()){
                printWriter.write(iterable.next().toString());
            }
            printWriter.close();
        } catch (IOException var5) {
            //this.logger.warn("write file error", var5);
        }
    }
}
