(defproject pedestal-api-swagger "0.1.0-SNAPSHOT"
  :description "An example project for pedestal-api"
  :url "https://github.com/lambdanadasomething/pedestal-api-swagger"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [pedestal-api "0.3.4" :exclusions [prismatic/schema]]
                 [prismatic/schema "1.1.3"]
                 [io.pedestal/pedestal.service "0.5.3"]
                 [io.pedestal/pedestal.jetty "0.5.3"]

                 [ch.qos.logback/logback-classic "1.1.8" :exclusions [org.slf4j/slf4j-api]]
                 [org.slf4j/jul-to-slf4j "1.7.22"]
                 [org.slf4j/jcl-over-slf4j "1.7.22"]
                 [org.slf4j/log4j-over-slf4j "1.7.22"]
                 [org.clojure/tools.logging "0.3.1"]]
  :main ^:skip-aot pedestal_api_swagger.server
  :target-path "target/%s"
  :uberjar-name "pedestal-api-swagger-standalone.jar"
  :profiles {:uberjar {:aot :all}
             :dev {:repl-options {:init-ns pedestal-api-swagger.server}}})
