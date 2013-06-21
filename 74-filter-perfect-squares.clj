(fn [s]
  (let [num-seq (map #(Integer/parseInt %) (re-seq #"\d+" s))]
    (apply str (interpose "," (filter (set (take-while #(<= % (apply max num-seq)) (map #(* % %) (range)))) num-seq)))))