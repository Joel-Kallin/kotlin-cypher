package enigma.components

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PermutationTest {
    @Test
    fun identityPermutationReturnsIdentity() {
        val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        // given
        val identityPermutation = Permutation()

        // when
        val permutation = alphabet.map { identityPermutation.permute(it) }.joinToString(separator = "")

        // then
        assertEquals(alphabet, permutation)
    }

    @Test
    fun permutationOfPermutationReturnsOriginal() {
        val permutationString = "BA"
        // given
        val permutor = Permutation(permutationString)

        // when
        val permutation = permutor.permute(permutor.permute('A'))

        // then
        assertEquals(permutation, 'A')
    }

    @Test
    fun undefinedPermutationIsIdentity() {
        val permutationString = "BA"
        // given
        val permutor = Permutation(permutationString)

        // when
        val permutation = permutor.permute(permutor.permute('C'))

        // then
        assertEquals(permutation, 'C')
    }

    @Test
    fun throwsOnNoInput() {
        // given
        val identityPermutation = Permutation()

        // when then
        assertThrows(IllegalArgumentException::class.java) { identityPermutation.permute(Character.MIN_VALUE) }
    }
}