(defn my-map [delegate collection]
  (seq (reduce
         (fn [acc x] (conj acc (delegate x)))
         [] collection))
  )

(defn my_filter [delegate collection]
  (seq (reduce
         (fn [acc x]
           (if (delegate x) (conj acc x) acc))
         [] collection))
  )


(println (my-map inc (list 1 2 3)))

(println (my_filter even? (list 2 3 4 5 6)))
