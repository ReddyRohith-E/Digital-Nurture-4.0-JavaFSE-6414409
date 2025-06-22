# Analysis & Comparison: Bubble Sort vs Quick Sort

## Bubble Sort
- **Working:** Bubble Sort goes through the list multiple times, comparing pairs of neighboring items and swapping them if they’re in the wrong order.
- **Performance:** It has a time complexity of O(n²) for both average and worst cases, making it slow for large lists.
- **Memory usage:** Requires only a small, constant amount of extra space (O(1)).
- **Stability:** Maintains the order of equal elements.
- **Best for:** Simple to code and understand, but only practical for very small or nearly sorted datasets.

## Quick Sort
- **Working:** Quick Sort picks a ‘pivot’ value, splits the list into items less than and greater than the pivot, and sorts those parts recursively.
- **Performance:** Average time complexity is O(n log n), though it can degrade to O(n²) in rare cases with poor pivot choices.
- **Memory usage:** Uses O(log n) extra space due to recursion.
- **Stability:** Not stable by default, so equal elements might not keep their original order.
- **Best for:** Handles large datasets efficiently and is commonly used in real-world applications.

## Why Quick Sort is Often Chosen
Quick Sort is usually favored over Bubble Sort because it’s much faster for sorting large collections. While Bubble Sort is easy to grasp, its slow speed makes it unsuitable for most practical uses. Quick Sort’s efficiency and scalability make it a better fit for tasks like organizing customer orders by price.