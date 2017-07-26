package org.bearmug.spark;

import org.bearmug.FibonacciCalc;

import static spark.Spark.*;

public class SparkApp {
    public static void main(String[] args) {
        port(8060);
        get("/fibonacci-spark/get/:base", (req, res) ->
                new FibonacciCalc().fibonacci(Integer.parseInt(req.params(":base"))));
    }
}
