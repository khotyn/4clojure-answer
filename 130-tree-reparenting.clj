(fn [root tree]
  (letfn [(find-parent [r t]
            (if (> (count t) 1)
              (let [sub-tree (filter #(some #{r} %) (next t))]
                (if (seq sub-tree)
                  [(first t)]
                  (apply concat (map #(find-parent r %) (next t)))))))
          (find-children [r t]
            (if (= r (first t))
              (map first (next t))
              (apply concat (map #(find-children r %) (next t)))))
          (step [r t s]
            (let [filtered-children (filter #(nil? (s %)) (concat (find-children r t) (find-parent r t)))]
              (cons r (map #(step % t (into s filtered-children)) filtered-children))))]
    (step root tree #{root})))
