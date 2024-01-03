import java.math.BigInteger;

class DH {

	private BigInteger p = new BigInteger("3"); // Large prime number
	private BigInteger g = new BigInteger("15"); // Generator

	public static void main(String[] args) {
		DH dh = new DH();
		if (args.length == 1) {
			// Generate public key
			BigInteger privateKey = new BigInteger(args[0]);
			BigInteger publicKey = dh.generatePublicKey(privateKey);
			System.out.println("Public Key: " + publicKey);
		} else if (args.length == 2) {
			// Calculate session key
			BigInteger privateKey = new BigInteger(args[0]);
			BigInteger recipientPublicKey = new BigInteger(args[1]);
			BigInteger sessionKey = dh.calculateSessionKey(privateKey, recipientPublicKey);
			System.out.println("Session Key: " + sessionKey);
		} else {
			System.out.println("Invalid arguments. Usage:");
			System.out.println("  java DH private_key");
			System.out.println("  java DH private_key public_key_of_recipient");
		}
	}

	public BigInteger generatePublicKey(BigInteger privateKey) {
		return g.modPow(privateKey, p);
	}

	public BigInteger calculateSessionKey(BigInteger privateKey, BigInteger recipientPublicKey) {
		return recipientPublicKey.modPow(privateKey, p);
	}
}
