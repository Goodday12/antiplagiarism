package com.development5053.antiplagiarism.model.service.impl;

import com.development5053.antiplagiarism.model.service.FinderWorker;
import com.development5053.antiplagiarism.util.similirityFinder.MatchingBlock;
import com.development5053.antiplagiarism.util.similirityFinder.SimilarityFinder;

import java.util.List;

public class FinderWorkerImpl implements FinderWorker {

    private final SimilarityFinder similarityFinder;

    public FinderWorkerImpl(SimilarityFinder similarityFinder) {
        this.similarityFinder = similarityFinder;
    }

    @Override
    public double lookForSimilarities(String file1, String file2, SimilarityFinder.Lang lang, List<MatchingBlock> list) {
        return similarityFinder.findSimilarity(file1, file2, lang, list);
    }
}
