package org.chenxh.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.chenxh.web.entity.Chapter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChapterService extends IService<Chapter> {

    void insertChapters(List<Chapter> chapterList);

    int insertChapter(Chapter chapter);

    int selectMaxSortIdByBookId(int bookId);

    Chapter selectChapterByBookIdAndSortId(String bookId,String sortId);
}
