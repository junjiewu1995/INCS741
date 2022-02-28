# RowTranspositionCipher

The transposition cipher means that we change the order of the plan-text and rearrange to get ciphertext. Row transportation cipher is the plan-text that is written in rows of fixed length, and we write by column in key order. To enhance the complexity we can follow the procedure to get a more complex cipher-text.

## Run

Install the docker desktop.

Put the Dockerfile and the RowTranspositionCipher.java the same directory.

Build a docker.
```bash
docker build -t java-app .
```

Run the docker.
```bash
docker run java-app
```

## Run in JDK environment

Compile the file
```bash
javac RowTranspositionCipher.java
```

```bash
java RowTranspositionCipher
```

## Input and Output

Input a and b:
![jupyter](https://github.com/XinyanZhang027/ML/raw/main/input1.PNG)

Output:
![jupyter](https://github.com/XinyanZhang027/ML/raw/main/output1.PNG)

