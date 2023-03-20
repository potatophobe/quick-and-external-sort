package ru.potatophobe.quickandexternalsort

fun quickSort(array: IntArray) {
    array._quickSort(0, array.lastIndex)
}

private fun IntArray._quickSort(startIndex: Int, endIndex: Int) {
    if (startIndex >= endIndex) return

    val middleIndex = this._quickSort_split(startIndex, endIndex)

    this._quickSort(startIndex, middleIndex - 1)
    this._quickSort(middleIndex + 1, endIndex)
}

private fun IntArray._quickSort_split(startIndex: Int, endIndex: Int): Int {
    var middleIndex = startIndex - 1

    for (i in startIndex..endIndex) {
        if (this[i] <= this[endIndex]) {
            this.swap(++middleIndex, i)
        }
    }

    return middleIndex
}


fun mergeSort(array: IntArray) {
    array._mergeSort(0, array.lastIndex)
}

private fun IntArray._mergeSort(startIndex: Int, endIndex: Int) {
    if (startIndex >= endIndex) return

    val middleIndex = (startIndex + endIndex) / 2

    this._mergeSort(startIndex, middleIndex)
    this._mergeSort(middleIndex + 1, endIndex)
    this._mergeSort_merge(startIndex, middleIndex, endIndex)
}

private fun IntArray._mergeSort_merge(startIndex: Int, middleIndex: Int, endIndex: Int) {
    val tempArray = IntArray(endIndex - startIndex + 1)

    var aIndex = startIndex
    var bIndex = middleIndex + 1
    var tIndex = 0

    while (aIndex <= middleIndex && bIndex <= endIndex) {
        if (this[aIndex] < this[bIndex]) {
            tempArray[tIndex++] = this[aIndex++]
        } else {
            tempArray[tIndex++] = this[bIndex++]
        }
    }

    while (aIndex <= middleIndex) {
        tempArray[tIndex++] = this[aIndex++]
    }

    while (bIndex <= endIndex) {
        tempArray[tIndex++] = this[bIndex++]
    }

    for (i in startIndex..endIndex) {
        this[i] = tempArray[i - startIndex]
    }
}


fun IntArray.swap(i: Int, j: Int) {
    val iValue = this[i]
    this[i] = this[j]
    this[j] = iValue
}
