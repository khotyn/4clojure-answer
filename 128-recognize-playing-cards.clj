(fn [s]
	(let [suit (first s) rank (last s)]
			(assoc
				{}
				:suit
				(case suit
					\D :diamond
					\H :heart
					\C :club
					:spades)
				:rank
				(case rank
					\2 0
					\3 1
					\4 2
					\5 3
					\6 4
					\7 5
					\8 6
					\9 7
					\T 8
					\J 9
					\Q 10
					\K 11
					12))))