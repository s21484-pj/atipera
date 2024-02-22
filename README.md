Simple REST API application. It consumes request with GitHub username

```
localhost:8080/github/{username}
```

and returns user data in such a format:

```
- repository name
- owner login
- each branch:
      - name
      - last commit sha
```