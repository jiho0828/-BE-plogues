package com.iso.plogues.page;

import org.springframework.stereotype.Service;

@Service
public class pageUtil {

	public PageInfo getPageInfo(int listCount, int currentPage, int boardLimit, int pageLimit) {
		if(currentPage < 1) {
			currentPage = 1;
		}
		int maxPage = (int)Math.ceil((double)listCount / boardLimit);
		int startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		int endPage = startPage + pageLimit - 1;
		int offset = (currentPage - 1) * boardLimit;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		return PageInfo.builder()
					   .listCount(listCount)
					   .currentPage(currentPage)
					   .boardLimit(boardLimit)
					   .pageLimit(pageLimit)
					   .maxPage(maxPage)
					   .startPage(startPage)
					   .endPage(endPage)
					   .offset(offset)
					   .build();
	}
}
