package org.chenxh.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.chenxh.web.entity.Chapter;
import org.chenxh.web.mapper.ChapterMapper;
import org.chenxh.web.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter> implements ChapterService {
    @Autowired
    private ChapterMapper chapterMapper;

    @Override
    public void insertChapters(List<Chapter> chapterList) {
        chapterList.forEach((a)->chapterMapper.insert(a));
    }

    @Override
    public int insertChapter(Chapter chapter) {
        return chapterMapper.insert(chapter);
    }

    @Override
    public int selectMaxSortIdByBookId(int bookId) {
        return chapterMapper.selectMaxSortIdByBookId(bookId);
    }
}
