(def N 4)
(def symbols ['a 'b 'c 'd])
(println N)
(println symbols)
(
  defn createReplacement [finalStr, symbols]
  (if (= (count finalStr) N)
    (str finalStr)
    (for [symbol symbols]
      (createReplacement (str finalStr symbol) (remove #{symbol} symbols))
      )
    )
  )

(println  (flatten (createReplacement "" symbols)))