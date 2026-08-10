# Architecture Overview

High-level architecture:
- Microservices per DDD domain: workflow-service, task-service, user-service
- Database-per-service (Postgres suggested)
- API Gateway in front (rate limiting)
- Istio service mesh with circuit breakers
- Observability: Prometheus + Grafana, Zipkin / OpenTelemetry tracing

Design principles: SOLID, DDD, TDD/BDD, 12-factor app
