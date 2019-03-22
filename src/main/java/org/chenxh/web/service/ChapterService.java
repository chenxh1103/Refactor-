package org.chenxh.web.service;

import org.chenxh.web.eneity.Chapter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChapterService {

    void insertChapters(List<Chapter> chapterList);

    int insertChapter(Chapter chapter);
}
