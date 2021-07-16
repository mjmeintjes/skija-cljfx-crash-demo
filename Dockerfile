FROM clojure:openjdk-16-tools-deps
RUN apt-get update && apt-get install -y --no-install-recommends xvfb xauth openjfx && rm -rf /var/lib/apt/lists/*
WORKDIR /app
COPY . /app
RUN clj -M -e "(println 1)"
