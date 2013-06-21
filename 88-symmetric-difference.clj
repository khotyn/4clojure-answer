(fn [a b]
	(set (concat (filter #(not (a %)) b) (filter #(not (b %)) a))))