package com.development5053.antiplagiarism.model.service;

import com.development5053.antiplagiarism.util.similirityFinder.MatchingBlock;
import com.development5053.antiplagiarism.util.similirityFinder.SimilarityFinder;

import java.util.List;

public interface FinderWorker {

    double lookForSimilarities(String file1, String file2, SimilarityFinder.Lang lang, List<MatchingBlock> list);

}
