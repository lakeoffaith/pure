package com.ijoy.gh.service;

import com.ijoy.common.query.PageResult;
import com.ijoy.common.service.BaseCurdService;
import com.ijoy.gh.domain.Dictionary;
import com.ijoy.gh.query.DictionaryQuery;

public interface DictionaryService extends BaseCurdService<Dictionary> {

	PageResult<Dictionary> queryDictionary(DictionaryQuery baseQuery);

}
