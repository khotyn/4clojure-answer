(fn [coll-a coll-b]
	(reduce + (map * coll-a coll-b)))