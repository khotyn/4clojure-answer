(fn [words]
  (letfn [(next? [word-c word-n]
            (case (- (count word-c) (count word-n))
              1 (true? (some #(= (seq word-n) %) (map #(concat (take % word-c) (next (drop % word-c))) (range 0 (count word-c)))))
              -1 (true? (some #(= (seq word-c) %) (map #(concat (take % word-n) (next (drop % word-n))) (range 0 (count word-n)))))
              0 (= 1 (count (filter false? (map #(= %1 %2) word-c word-n))))
              false))
          (chain [word searched-word words]
            (let [nexts (filter #(and (next? word %) (nil? (searched-word %))) words)]
              (if (seq nexts)
                (true? (some true? (map #(chain % (set (cons % searched-word)) words) nexts)))
                (= (count searched-word) (count words)))))]
    (true? (some true? (map #(chain % #{%} words) words)))))