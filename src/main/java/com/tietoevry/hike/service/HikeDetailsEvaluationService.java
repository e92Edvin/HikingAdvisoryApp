package com.tietoevry.hike.service;

import com.tietoevry.hike.model.ValidatedHikeDetails;

public interface HikeDetailsEvaluationService<S> {
     S evaluate(ValidatedHikeDetails input);
}
