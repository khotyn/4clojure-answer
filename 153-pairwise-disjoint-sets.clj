(fn [coll]
	(every?
		false?
		(flatten (map
			(fn [[a b]]
				(map
					(fn [eleA]
						(map
							(fn [eleB] (= eleA eleB))
							b))
					a))
			(partition 2 1 coll)))))