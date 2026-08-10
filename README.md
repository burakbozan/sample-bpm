# BPM Tool Project Specification

## Overview
We are building a BPM (Business Process Management) tool similar to Camunda, with both **frontend** and **backend** components.  
The backend will be developed using **Java, Spring Boot, and Spring Cloud**, while the frontend can be implemented using any modern framework (React, Angular, Vue).  

The project must follow **OOP principles**, **BDD, DDD, TDD methodologies**, and apply **Gang of Four design patterns** where appropriate.  
It must adhere to the **12-factor app methodology** and be designed as a **microservice architecture**.

---

## Architecture & Principles
- **Microservices** separated by **DDD domains**.
- **Database per service** pattern.
- **API Gateway** with **rate limiting**.
- **Service mesh (Istio)** with **circuit breaker**.
- **Deployment** on **Kubernetes / OpenShift**.
- **Resilience & observability** baked in (logging, tracing, metrics).
- **Non-functional requirements**: scalability, fault tolerance, maintainability.

---

## Development Workflow
- Create all folders and files like a professional developer.
- Generate `.md` files for documentation (architecture, coding standards, etc.).
- Commit all changes to the GitHub repository.
- Define **code review rules** for pull requests.

---

## Deliverables
- **Backend services**:
  - Workflow Service
  - Task Service
  - User Service
  - Common Libraries
- **Frontend UI**:
  - Workflow Designer
  - Monitoring Dashboard
- **DevOps setup**:
  - CI/CD pipeline
  - Helm charts
  - Kubernetes manifests
- **Documentation**:
  - `README.md`
  - `ARCHITECTURE.md`
  - `CODE_REVIEW_RULES.md`
  - `CONTRIBUTING.md`
- **Testing setup**:
  - Unit tests
  - Integration tests
  - BDD scenarios

---

## Example Folder Structure
