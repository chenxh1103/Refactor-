package org.chenxh.web.serviceImpl;

import org.chenxh.web.eneity.Chapter;
import org.chenxh.web.mapper.ChapterMapper;
import org.chenxh.web.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChapterServiceImpl implements ChapterService {
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
}
