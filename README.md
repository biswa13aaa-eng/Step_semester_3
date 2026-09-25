# Step_semester_3
Semester 3 projects, assignments, and programming practice work.

## Date: 25-09-2026
**Today's Work:**
- Completed Session 7 (OOP / Encapsulation & Access Control) problems on `feature/session_7`.
- Solved 5 Class Problems in `encapsulation.class_problems`:
  - `PiggyBank.java`: Private savings with safe deposit, overdraft rejection on withdrawal, and final ID.
  - `Scorecard.java`: Private answer recording array exposing only computed score without exposing raw data.
  - `NameTag.java`: Immutable name tag class splitting full name once and returning formatted nickname.
  - `Locker.java`: Write-only combination code requiring current code verification before mutation.
  - `AttendanceSheet.java`: Internal array storing present students without duplicates and providing query methods.
- Solved 5 Assignment Problems in `encapsulation.assigment_problems`:
  - `Character.java`: Health bar clamped strictly between 0 and final maxHealth through takeDamage and heal.
  - `Playlist.java`: Defensive copying of internal song array to prevent external mutation.
  - `PasswordChecker.java`: Write-only password storage returning only strength ratings without exposing password text.
  - `TrafficLight.java`: Strict color cycle (RED -> GREEN -> YELLOW -> RED) through next() with final identifier.
  - `Cart.java`: Internal price storage exposing on-demand computed total and item count without exposing array.
- Compiled and verified all 10 Java solutions against test cases.
**Next Session Plan:**
- Proceed to Session 8 problems once uploaded and maintain clean branch isolation.
**Issues Faced:**
- None. All 10 solutions compiled cleanly and verified with expected outputs.

## Date: 25-09-2026
**Today's Work:**
- Completed Session 6 (OOP / Encapsulation, Reference Management & Constructors) problems on `feature/session_6`.
- Solved 5 Class Problems in `object_oriented_programming.class_problems`:
  - `PlacementRecord.java`: Structured placement records using OOP and object array traversal.
  - `MessWallet.java`: Encapsulation with validation for negative opening balance, top-up, and overdraft protection.
  - `Course.java`: Constructor overloading and chaining via `this(...)` for theory and lab course configurations.
  - `IdCard.java`: Demonstrating reference aliasing versus separate object allocation using `==` equality checks.
  - `Student.java`: Shared static attributes (`collegeName`) and class-level counter (`studentCount`) with static accessor.
- Solved 5 Assignment Problems in `object_oriented_programming.assigment_problems`:
  - `BookInventory.java`: Multi-field book inventory management using custom object arrays.
  - `PayrollAccount.java`: Strict encapsulation of salary and bonus with percentage tax deduction rules.
  - `EmployeeProfile.java`: Constructor chaining for intern vs. permanent employee profiles.
  - `HallTicket.java`: Object reference mutation demonstration and reference comparison with `==`.
  - `CompanyEmployee.java`: Static company name and employee counter accessed through class name.
- Handled class name collision between M3 and M5 by defining distinct descriptive classes (`EmployeeProfile` and `CompanyEmployee`).
- Compiled and verified all 10 Java solutions against test cases.
**Next Session Plan:**
- Proceed to Session 7 problems once uploaded and maintain clean branch isolation.
**Issues Faced:**
- Addressed duplicate class name `Employee` between M3 and M5 in assignment problems by adopting clear, unique class names.

## Date: 11-09-2026
**Today's Work:**
- Completed Session 5 (Array Operations, 2D Arrays & Custom Objects) problems on `feature/session_5`.
- Solved 5 Class Problems in `array.class_problems`:
  - `HackathonScoreCurveBooster.java`: Modify array elements in place by adding bonus points.
  - `DuplicateTeamNameFinder.java`: Scan array for duplicate strings using nested loops.
  - `TopThreePodiumFinder.java`: Track top 3 podium scores in a single pass without sorting.
  - `HackathonSeatingGridOptimizer.java`: Analyze 2D jagged seating grid and classify rows based on average threshold.
  - `Candidate.java`: Encapsulate candidate data, evaluate overloaded eligibility checks, and rank shortlisted candidates via Comparable.
- Solved 5 Assignment Problems in `array.assigment_problems`:
  - `FantasyTeamScoreMultiplier.java`: Boost captain and vice-captain scores directly in place by reference.
  - `DuplicatePlayerPickChecker.java`: Detect repeated player picks in lineup using nested-loop pairwise comparison.
  - `TopPerformerTracker.java`: Find minimum, maximum, and spread in single pass without sorting.
  - `MatchDayGridAnalyzer.java`: Reusable rowAverage helper to classify match overs into Power Surge vs. Normal.
  - `Player.java`: Overloaded draftability rules, natural sorting via Comparable<Player>, and auto-draft ranking string output.
- Compiled and verified all 10 Java solutions against test cases.
**Next Session Plan:**
- Proceed to Session 6 problems once uploaded and maintain clean branch isolation.
**Issues Faced:**
- None. All 10 solutions compiled cleanly and verified with expected outputs.

## Date: 11-09-2026
**Today's Work:**
- Completed Session 4 (Array / Functions & Arrays) problems on `feature/session_4`.
- Solved 5 Class Problems in `array.class_problems`:
  - `TwoSum.java`: Find pair of indices adding up to target using nested loops.
  - `BestTimeToBuyAndSellStock.java`: Compute maximum profit in a single pass tracking minimum price.
  - `ContainsDuplicate.java`: Check for duplicate elements in array using pairwise comparison.
  - `MergeTwoSortedArrays.java`: Merge two sorted integer arrays into one sorted array using two pointers.
  - `RotateArray.java`: Rotate array right by k steps using modulo arithmetic and new position mapping.
- Solved 5 Assignment Problems in `array.assigment_problems`:
  - `ProductOfArrayExceptSelf.java`: Compute product except self without division using forward and backward passes.
  - `MaximumSubarray.java`: Find contiguous subarray with maximum sum using Kadane's algorithm.
  - `ThreeSum.java`: Find all unique triplets summing to zero using sorting and two-pointer scan with duplicate avoidance.
  - `SubarraySumEqualsK.java`: Count total contiguous subarrays summing to k using prefix sums and frequency map.
  - `FindMinimumInRotatedSortedArray.java`: Find minimum element in rotated sorted array in O(log n) using binary search.
- Compiled and verified all 10 Java solutions against test cases.
**Next Session Plan:**
- Proceed to Session 5 problems once uploaded and maintain clean branch isolation.
**Issues Faced:**
- None. All 10 solutions compiled cleanly and verified with expected outputs.

## Date: 11-09-2026
**Today's Work:**
- Completed Session 3 (OOP / Classes and Objects) problems on `feature/session_3`.
- Solved 5 Class Problems in `object_oriented_programming.class_problems`:
  - `Student.java`: Define student record class with name and marks, create object and set fields directly.
  - `HostelRoom.java`: Demonstrate independent state across multiple room objects without interference.
  - `LibraryCard.java`: Demonstrate Java's default field values (null, 0, false) upon object instantiation.
  - `Course.java`: Implement parameterized constructor initializing fields using `this`.
  - `Applicant.java`: Track total object count using a static field incremented within constructor.
- Solved 5 Assignment Problems in `object_oriented_programming.assigment_problems`:
  - `Book.java`: Define book record class with title and price, instantiate and set fields directly.
  - `ExamHall.java`: Demonstrate separate occupancy counts across multiple exam hall objects.
  - `Employee.java`: Verify default values for reference, primitive numeric, and boolean fields.
  - `Product.java`: Implement parameterized constructor for product ID and name using `this`.
  - `Order.java`: Count total orders created across session using a class-level static counter.
- Compiled and verified all 10 Java solutions against test cases.
**Next Session Plan:**
- Proceed to Session 4 problems once uploaded and maintain branch isolation.
**Issues Faced:**
- None. All programs compiled cleanly and verified with expected outputs.

## Date: 11-09-2026
**Today's Work:**
- Completed Session 2 (String) problems on `feature/session_2`.
- Solved 5 Class Problems in `string.class_problems`:
  - `VowelConsonantCounter.java`: Count vowels and consonants in a string ignoring spaces.
  - `CSVStudentRecordParser.java`: Parse and validate 3-field CSV student records.
  - `FileExtensionValidator.java`: Validate file extensions (pdf, docx, zip) using substring and lastIndexOf.
  - `MaskedPhoneNumberFormatter.java`: Validate 10-digit phone number and format as XXXXXX-last4 using StringBuilder.
  - `BankTransactionReferenceValidator.java`: Normalize reference and validate 3-letter bank code + 11 digits body.
- Solved 5 Assignment Problems in `string.assigment_problems`:
  - `AtmPinLengthValidator.java`: Validate exact 4-digit ATM PIN length.
  - `WordReversalEncoder.java`: Reverse each word individually while preserving word order.
  - `ProductInventoryCsvParser.java`: Parse CSV inventory records and format output.
  - `LibraryIsbnValidator.java`: Normalize ISBN code and validate 3-letter publisher + 10-digit body.
  - `StopWordWordFrequencyReport.java`: Filter stop words, normalize text, count frequencies, and sort in descending order.
- Compiled and verified all 10 Java solutions against test cases.
**Next Session Plan:**
- Proceed to Session 3 problems once uploaded and maintain clean branch isolation.
**Issues Faced:**
- None. Handled default PowerShell UTF-8 BOM encoding during compilation by saving files in standard BOM-free UTF-8.
