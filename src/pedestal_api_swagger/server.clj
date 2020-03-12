(ns pedestal-api-swagger.server
  (:require [pedestal-api-swagger.service :as service]
            [io.pedestal.http :as bootstrap])
  (:gen-class))

(defonce service-instance nil)

(defn create-server []
  (alter-var-root #'service-instance
                  (constantly (bootstrap/create-server
                               (-> service/service
                                   (assoc ::bootstrap/port (Integer. (or (System/getenv "PORT") 8080)))
                                   (bootstrap/default-interceptors))))))

(defn start []
  (when-not service-instance
    (create-server))
  (bootstrap/start service-instance))

(defn stop []
  (when service-instance
    (bootstrap/stop service-instance)))

(defn -main [& args]
  (start))